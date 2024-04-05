import React from "react";
import { footerText } from "../constants";

const Footer = () => {
  return (
    <div className="right">
      <h3>social</h3>
      <ul>
        {footerText.map((footer, key) => (
          <li key={key}>
            <a href={footer.link}>{footer.title}</a>
            <em>{footer.desc}</em>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Footer;
