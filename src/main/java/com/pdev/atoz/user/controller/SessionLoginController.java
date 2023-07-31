package com.pdev.atoz.user.controller;

import com.pdev.atoz.global.exception.DuplicateValueException;
import com.pdev.atoz.order.dto.OrderResponseDto;
import com.pdev.atoz.order.service.OrderService;
import com.pdev.atoz.user.domain.User;
import com.pdev.atoz.user.dto.UserJoinRequest;
import com.pdev.atoz.user.dto.UserLoginRequest;
import com.pdev.atoz.user.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/session")
public class SessionLoginController {

    private final UserServiceImpl userServiceImpl;
    private final OrderService orderService;

    public SessionLoginController(UserServiceImpl userServiceImpl, OrderService orderService) {
        this.userServiceImpl = userServiceImpl;
        this.orderService = orderService;
    }

    @GetMapping
    public String home(Model model, @SessionAttribute(name = "userId", required = false) Long userId) {
        model.addAttribute("loginType", "session");
        model.addAttribute("pageName", "데브코스의 민족");

        try {
            User loginUser = userServiceImpl.getLoginUserById(userId);
            if (loginUser != null) {
                model.addAttribute("user", loginUser);
            }
        } catch (RuntimeException e) {
        }
        return "/users/home";
    }

    @GetMapping("/join")
    public String joinPage(Model model, UserJoinRequest userJoinRequest) {
        model.addAttribute("loginType", "session");
        model.addAttribute("pageName", "데브코스의 민족");

        model.addAttribute("userJoinRequest", userJoinRequest);
        return "/users/join";
    }

    @PostMapping("/join")
    public String join(@Valid @ModelAttribute("userJoinRequest") UserJoinRequest userJoinRequest, BindingResult bindingResult, Model model) {
        model.addAttribute("loginType", "session");
        model.addAttribute("pageName", "데브코스의 민족");

        if (!userJoinRequest.getPassword().equals(userJoinRequest.getPasswordCheck())) {
            bindingResult.addError(new FieldError("joinRequest", "passwordCheck", "비밀번호 확인이 일치하지 않습니다."));
        }

        if (bindingResult.hasErrors()) {
            return "/users/join";
        }

        try {
            userServiceImpl.userJoin(userJoinRequest);
        } catch (DuplicateValueException e) {
            bindingResult.addError(new FieldError("joinRequest", e.getField(), e.getMessage()));
            return "/users/join";
        }

        return "redirect:/session";
    }

    @GetMapping("/login")
    public String loginPage(Model model, UserLoginRequest userLoginRequest) {
        model.addAttribute("loginType", "session");
        model.addAttribute("pageName", "데브코스의 민족");

        model.addAttribute("userLoginRequest", userLoginRequest);

        return "/users/login";
    }


    @PostMapping("/login")
    public String join(@ModelAttribute UserLoginRequest userLoginRequest, BindingResult bindingResult, HttpServletRequest httpServletRequest, Model model) {
        model.addAttribute("loginType", "session");
        model.addAttribute("pageName", "데브코스의 민족");

        try {
            User loginUser = userServiceImpl.login(userLoginRequest);

            httpServletRequest.getSession().invalidate();
            HttpSession session = httpServletRequest.getSession(true); // 세션이 없으면 생성

            session.setAttribute("userId", loginUser.getId());
            session.setMaxInactiveInterval(1800);

        } catch (RuntimeException e) {
            bindingResult.reject("로그인 실패", "로그인 아이디 또는 비밀번호가 틀렸습니다.");
            return "/users/login";
        }

        return "redirect:/session";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest, Model model) {
        model.addAttribute("loginType", "session");
        model.addAttribute("pageName", "데브코스의 민족");

        HttpSession session = httpServletRequest.getSession(false); // 세션이 없으면 null return

        if (session != null) {
            session.invalidate();
        }

        return "redirect:/session/login";
    }

    @GetMapping("/info")
    public String userInfo(@SessionAttribute(name = "userId", required = false) Long userId, Model model) {
        model.addAttribute("loginType", "session");
        model.addAttribute("pageName", "데브코스의 민족");

        User loginUser = userServiceImpl.getLoginUserById(userId);

        if (loginUser == null) {
            return "redirect:/session/login";
        }

        List<OrderResponseDto> orders = orderService.findOrderByUserId(userId);

        model.addAttribute("user", loginUser);
        model.addAttribute("orders", orders);

        return "/users/info";
    }

    @GetMapping("/rider")
    public String riderPage(@SessionAttribute(name = "userId", required = false) Long userId, Model model) {
        model.addAttribute("loginType", "session");
        model.addAttribute("pageName", "데브코스의 민족");

        User loginUser = userServiceImpl.getLoginUserById(userId);

        if (loginUser == null) {
            return "redirect:/session/login";
        }

        List<OrderResponseDto> orders = orderService.findOrders();

        model.addAttribute("orders", orders);

        return "/users/order-list";
    }

}
