import React from "react";
import styled from "styled-components";

const LoginBlock = styled.div`
  height: 100vh;
  display: flex;
  background-color: #131722;
`;

const AniBlock = styled.div`
  width: 50%;
`;

const SignInBlock = styled.div`
  width: 360px;
  color: rgb(255 255 255);
`;

const FormBlock = styled.form``;

const Login = () => {
  return (
    <LoginBlock>
      <AniBlock></AniBlock>
      <SignInBlock>
        <h1>Sign in</h1>
        <FormBlock></FormBlock>
      </SignInBlock>
    </LoginBlock>
  );
};
export default Login;
