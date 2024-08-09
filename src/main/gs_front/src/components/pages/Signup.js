import React, { useState } from "react";
import styled from "styled-components";
import axios from "axios";

// Styled Components
const PageContainer = styled.div`
  display: flex;
  width: 100%;
  height: 100%;
  flex-basis: 500px;
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

const Input = styled.input`
  width: 100%;
  padding: 1.25rem 27px 15px 27px;
  outline: 2px solid transparent;
  outline-offset: 2px;
  background-color: #f8f9fa;
  color: #333;
  box-sizing: border-box;

  &:focus {
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

const Signup = () => {
  const [signupInfo, setSignupInfo] = useState({
    email: "",
    id: "",
    password: "",
    phoneNum: "",
  });

  const handleChange = (e) => {
    const eventInfo = JSON.parse(
      `{"${e.target.id}":${JSON.stringify(e.target.value)}}`
    );
    setSignupInfo({
      ...signupInfo,
      ...eventInfo,
    });
  };

  const onClickSignup = (event) => {
    event.preventDefault();
    console.log(signupInfo);
    axios
      .post(`/api/comm/user/register`, signupInfo)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  return (
    <PageContainer>
      <LoginBox>
        <LoginInput>
          <Input
            type="text"
            id="id"
            value={signupInfo.id}
            placeholder="Id"
            required
            onChange={handleChange}
          />
        </LoginInput>
        <LoginInput>
          <Input
            type="text"
            id="password"
            value={signupInfo.password}
            placeholder="비밀번호"
            required
            onChange={handleChange}
          />
        </LoginInput>
        <LoginInput>
          <Input
            type="text"
            id="email"
            value={signupInfo.email}
            placeholder="이메일"
            required
            onChange={handleChange}
          />
        </LoginInput>
        <LoginInput>
          <Input
            type="text"
            id="phoneNum"
            value={signupInfo.phoneNum}
            placeholder="핸드폰번호"
            required
            onChange={handleChange}
          />
        </LoginInput>
        <Button onClick={onClickSignup}>회원가입</Button>
      </LoginBox>
    </PageContainer>
  );
};

export default Signup;
