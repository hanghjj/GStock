import React from "react";
// import { Link } from "react-router-dom";
import styled from "styled-components";

const HeaderBlock = styled.div`
  #header {
    @include position-fixed; // 위치 고정
  }
`;

const HeaderInner = styled.div`
  background-color: #131722;
  padding: 1.5rem;
  display: flex;
  color: rgb(255 255 255);
  justify-content: space-between;
  width: 100%;

  a {
    text-decoration-line: none;
  }
`;

const HeaderLogo = styled.div`
  display: flex;
  width: 100px;
  font-size: 0.9rem;
  text-align: center;
  align-items: center;
  justify-content: center;
  text-transform: uppercase;
  margin-right: 4.8rem;

  a {
    color: rgb(255 255 255);
    text-decoration-line: none;
  }
`;

const HeaderNavLeft = styled.div`
  display: flex;
`;

const HeaderNavRight = styled.div`
  display: flex;
`;

const HeaderNavInfo = styled.div`
  color: rgb(255 255 255);
  margin-right: 3.2rem;
`;

const Header = () => {
  return (
    <HeaderBlock>
      <header id="header" role="banner">
        <HeaderInner
          className="header__nav"
          role="navigation"
          aria-label="메인 메뉴"
        >
          <HeaderNavLeft>
            <HeaderLogo>
              <a href="/">GStock</a>
            </HeaderLogo>
            <a href="/indexInfo">
              <HeaderNavInfo>지수정보</HeaderNavInfo>
            </a>
            <a href="/stockInfo">
              <HeaderNavInfo>종목정보</HeaderNavInfo>
            </a>
            <a href="/dividendInfo">
              <HeaderNavInfo>배당정보</HeaderNavInfo>
            </a>
            <a href="/portfolio">
              <HeaderNavInfo>포트폴리오</HeaderNavInfo>
            </a>
            <a href="/dividendSchedule">
              <HeaderNavInfo>배당일지</HeaderNavInfo>
            </a>
          </HeaderNavLeft>
          <HeaderNavRight>
            <a href="/myPage">
              <HeaderNavInfo>마이페이지</HeaderNavInfo>
            </a>
            <a href="/login">
              <HeaderNavInfo>로그인</HeaderNavInfo>
            </a>
          </HeaderNavRight>
        </HeaderInner>
      </header>
    </HeaderBlock>
  );
};

export default Header;
