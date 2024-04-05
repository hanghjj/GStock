import React from "react";
import { Outlet } from "react-router-dom";
import Header from "../components/Header";
import Main from "../components/Main";
import styled from "styled-components";

const MainBlock = styled.div`
  display: flex;
`;
const MainLayout = () => {
  return (
    <div>
      <Header />
      <MainBlock>
        <Main>
          <Outlet />
        </Main>
      </MainBlock>
    </div>
  );
};

export default MainLayout;
