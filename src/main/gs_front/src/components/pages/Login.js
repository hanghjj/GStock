import React from "react";
import styled from "styled-components";
import stockImage from "../../assets/img/recession-banking-statistics-bad-street.jpg"; // 여기에 주식 이미지 경로를 넣으세요
import axios from "axios";

// Styled Components
const PageContainer = styled.div`
  display: flex;
  width: 100%;
  height: 100%;
  flex-basis: 500px;
`;

const ImageContainer = styled.div`
  flex-basis: 50%;
  background: url(${stockImage}) no-repeat center center;
  background-size: cover;
`;

const LoginContainer = styled.div`
  flex-basis: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
`;

const LoginBox = styled.div`
  padding: 40px;
  border-radius: 10px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  max-width: 400px;
  width: 100%;
  text-align: center;
`;

const LoginInput = styled.div`
  width: 100%;
  height: 58px;
  background-color: rgb(29 29 29/1);
  border-width: 1px;
  border-radius: 9999px;
  line-height: 17px;
  margin-bottom: 1rem;
`;

const Title = styled.h1`
  font-size: 24px;
  color: #ffffff;
  margin-bottom: 20px;
`;

const Input = styled.input`
  width: 100%;
  padding: 1.25rem 27px 15px 27px;
  outline: 2px solid transparent;
  outline-offset: 2px;
  background-color: #f8f9fa;
  color: #333;
  box-sizing: border-box;

  &:focus {
    border-color: #007bff;
    background-color: #ffffff;
  }
`;

const Button = styled.button`
  width: 100%;
  padding: 1.25rem 27px 15px 27px;
  box-sizing: border-box;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
  margin-top: 10px;
  &:hover {
    background-color: #0056b3;
  }
`;

const Link = styled.a`
  color: #007bff;
  text-decoration: none;
  margin-top: 20px;
  display: inline-block;
  &:hover {
    text-decoration: underline;
  }
`;

// React Component
const Login = () => {
  const onClickLogin = () => {
    axios.post(`/api/comm/user/signin`);
  };

  return (
    <PageContainer>
      <ImageContainer />
      <LoginContainer>
        <LoginBox>
          <Title>Login</Title>
          <form>
            <LoginInput>
              <Input type="email" placeholder="Email" required />
            </LoginInput>
            <LoginInput>
              <Input type="password" placeholder="Password" required />
            </LoginInput>
            <Button onClick={onClickLogin}>Login</Button>
          </form>
          <Link href="/forgot-password">Forgot Password?</Link>
        </LoginBox>
      </LoginContainer>
    </PageContainer>
  );
};

export default Login;
