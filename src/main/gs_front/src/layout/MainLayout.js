import React from "react";
import { Outlet } from "react-router-dom";
import Header from "../components/Header";
import Main from "../components/Main";
import styled from "styled-components";

const MainLayoutBlock = styled.div`
  height: 100%;
`;

const MainBlock = styled.div`
  height: 100%;
  display: flex;
`;
const MainLayout = () => {
  return (
    <MainLayoutBlock>
      <Header />
      <MainBlock>
        <Main>
          <Outlet />
        </Main>
      </MainBlock>
    </MainLayoutBlock>
  );
};

export default MainLayout;
