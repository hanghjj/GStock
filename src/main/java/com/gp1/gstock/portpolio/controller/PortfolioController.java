package com.gp1.gstock.portpolio.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@AllArgsConstructor
@Tag(name = "Portfolio", description = "포트폴리오 관련 API")
@RequestMapping("/api/portfolio")
public class PortfolioController {


}
