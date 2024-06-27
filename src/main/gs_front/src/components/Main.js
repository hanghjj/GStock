import React from "react";
import styled from "styled-components";

// Styled Components
const MainContainer = styled.main`
  width: 100%;
  height: 100%;
`;

const Main = ({ children }) => {
  return (
    <MainContainer id="main" role="main">
      {children}
    </MainContainer>
  );
};

export default Main;
