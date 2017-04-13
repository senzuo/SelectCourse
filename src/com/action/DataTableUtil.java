package com.action;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bean.StudentBean;

public class DataTableUtil {

    public static List<StudentBean> get(Document document){
    	List<StudentBean> list = new ArrayList<StudentBean>();
        // element =>  table ���
        Element element = document.getElementById("table2");

        // Elementstr => ���� tr Ԫ��
        Elements AllElementstr = element.getElementsByTag("tr");
        StudentBean stubean = null;
        for (int i = 1; i < AllElementstr.size(); i++){
        	stubean = new StudentBean();
            // �� i �� trԪ��
            Element Elementstr = AllElementstr.get(i);
            // �� i �� tr Ԫ�ص�����td Ԫ��
            Elements AllElementstd = Elementstr.getElementsByTag("td");
            // ǰ 5 ��td Ԫ��
            	stubean.setStudent_Num(AllElementstd.get(1).text());
            	stubean.setStudent_Pwd(AllElementstd.get(1).text());
            	stubean.setStudent_Name(AllElementstd.get(2).text());
            	stubean.setStudent_Gender(AllElementstd.get(3).text());
            	stubean.setStudent_Class(AllElementstd.get(4).text());
            list.add(stubean);
        }
        return list;
    }
}
