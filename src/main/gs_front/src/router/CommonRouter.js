/**
 * 라우터
 * @author yejinkim
 * @date   2024.04.02
 */

/* import ----------------------------------------------------------*/
import React from "react";
import { Navigate, Route, Routes } from "react-router-dom";
import MainLayout from "../layout/MainLayout";
import Intro from "../components/Intro";
import IndexInfo from "../components/pages/IndexInfo";
import StockInfo from "../components/pages/StockInfo/index";
import DividendInfo from "../components/pages/DividendInfo";
import Portfolio from "../components/pages/Portfolio";
import DividendSchedule from "../components/pages/DividendSchedule";
import MyPage from "../components/pages/MyPage";
import Login from "../components/pages/Login";
import Signup from "../components/pages/Signup";

const CommonRouter = () => {
  return (
    <Routes>
      <Route element={<MainLayout />}>
        <Route path="/" element={<Navigate to="/intro" />}></Route>
        <Route path="/intro" element={<Intro />} />
        <Route path="/indexInfo" element={<IndexInfo />} />
        <Route path="/stockInfo" element={<StockInfo />} />
        <Route path="/dividendInfo" element={<DividendInfo />} />
        <Route path="/portfolio" element={<Portfolio />} />
        <Route path="/dividendSchedule" element={<DividendSchedule />} />
        <Route path="/myPage" element={<MyPage />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
      </Route>
    </Routes>
  );
};

export default CommonRouter;
