import React from "react";
import styled from "styled-components";

// Styled Components
const MainContainer = styled.main`
  width: 100%;
  height: auto;
  padding-top: 68px;
`;

const Main = ({ children }) => {
  return (
    <MainContainer id="main" role="main">
      {children}
    </MainContainer>
  );
};

export default Main;
