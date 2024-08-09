import React, { useState } from "react";
import styled from "styled-components";
import stockImage from "../../assets/img/recession-banking-statistics-bad-street.jpg";
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
  // background: url(${stockImage}) no-repeat center center;
  background-size: cover;
`;

const LoginContainer = styled.div`
  flex-basis: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  user-select: none;
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

const TitleBox = styled.div`
  margin-bottom: 50px;
`;

const Title = styled.h1`
  font-family: GT-Super-Display-Regular;
  font-weight: 100;
  font-size: 26px;
  color: #ffffff;
  margin-bottom: 20px;
`;

const SignupBox = styled.div`
  color: #ffffff;
`;

const SignupButton = styled.button`
  background-color: inherit;
  color: rgb(121 113 109);
  text-decoration: underline;
  border: none;
  cursor: pointer;
`;

const Input = styled.input`
  width: 100%;
  padding: 1.25rem 27px 15px 27px;
  background-color: transparent;
  color: #ffffff;
  box-sizing: border-box;
  border: none;

  &:focus {
    outline: none;
    cursor: default;
  }
`;

const Button = styled.button`
  width: 100%;
  padding: 1.25rem 27px 15px 27px;
  box-sizing: border-box;
  background-color: #ffffff;
  color: rgb(13 13 13);
  border: none;
  border-radius: 9999px;
  font-size: 16px;
  cursor: pointer;
  margin-top: 10px;
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
  const [id, setId] = useState();
  const [pw, setPw] = useState();

  const onClickLogin = (event) => {
    event.preventDefault();
    axios
      .post(`/api/comm/user/signin`, {
        id: id,
        password: pw,
      })
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const onIdChange = (e) => {
    e.preventDefault();
    setId(e.target.value);
  };

  const onPwChange = (e) => {
    e.preventDefault();
    setPw(e.target.value);
  };

  return (
    <PageContainer>
      <ImageContainer />
      <LoginContainer>
        <LoginBox>
          <TitleBox>
            <Title>Log in</Title>
            <SignupBox>
              or
              <SignupButton onClick={() => (window.location.href = "/signup")}>
                새로운 계정 만들기
              </SignupButton>
            </SignupBox>
          </TitleBox>
          <form>
            <LoginInput>
              <Input
                type="text"
                id="id"
                placeholder="Id"
                value={id}
                required
                onChange={onIdChange}
              />
            </LoginInput>
            <LoginInput>
              <Input
                type="password"
                id="pw"
                placeholder="Password"
                value={pw}
                required
                onChange={onPwChange}
              />
            </LoginInput>
            <Button onClick={onClickLogin}>Enter</Button>
          </form>
          <Link href="/forgot-password">Forgot Password?</Link>
        </LoginBox>
      </LoginContainer>
    </PageContainer>
  );
};

export default Login;
