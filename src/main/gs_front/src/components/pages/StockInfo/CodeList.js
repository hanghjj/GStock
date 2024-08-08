import React from "react";
import styled from "styled-components";
import { AgGridReact } from "ag-grid-react"; // React Data Grid Component
import "ag-grid-community/styles/ag-grid.css"; // Mandatory CSS required by the Data Grid
import "ag-grid-community/styles/ag-theme-quartz.css"; // Optional Theme applied to the Data Grid

const GridBox = styled.div`
  width: 50%;
  height: 100%;
`;
const CodeList = ({ codeList, onCellClicked }) => {
  const columnDefs = [
    { headerName: "주식명", field: "nm" },
    { headerName: "주식코드", field: "cd" },
    { headerName: "현재가격", field: "nv" },
    { headerName: "당일등락", field: "cr" },
  ];

  return (
    <GridBox className="ag-theme-quartz">
      <AgGridReact
        rowData={codeList}
        columnDefs={columnDefs}
        onCellClicked={onCellClicked}
      ></AgGridReact>
    </GridBox>
  );
};

export default CodeList;
