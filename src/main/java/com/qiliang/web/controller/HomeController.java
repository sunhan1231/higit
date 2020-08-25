package com.qiliang.web.controller;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qiliang.web.entity.*;
import com.qiliang.web.mapper.HomeMapper;

import com.qiliang.web.mapper.YJFXMapper;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;


//项目管理
@RestController
@RequestMapping("home")
public class HomeController {
    @Resource
    private HomeMapper homeMapper;
    @Resource
    private YJFXMapper yjfxMapper;

    //创建项目

    @RequestMapping("Allcontent")
    public JSONArray createProject(){
        List<Learnlist> learnlists=homeMapper.leanlis();
        JSONArray jsonArray=new JSONArray();
        for (Learnlist l:learnlists
        ) {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("img",l.getImg());
            System.out.println(l.getIntroductory());
            jsonObject.put("introductory",l.getIntroductory());
            jsonObject.put("title",l.getTitle());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    @RequestMapping("Allcontentlis")
    public JSONArray Allcontentlis(@RequestBody String qq){
        System.out.println(11+qq);
        List<Messagelist> messagelist=homeMapper.messagelist();
        JSONArray jsonArray=new JSONArray();
        for (Messagelist m:messagelist
        ) {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("img","filepath/img/"+m.getImg());
            System.out.println(m.getText());
            jsonObject.put("numB",m.getNumB());
            jsonObject.put("text",m.getText());
            jsonArray.add(jsonObject);
        }

        return jsonArray;

    }

    @RequestMapping("supportList")
    public JSONArray supportList(@RequestBody String qq){
        System.out.println(11+qq);
        List<Supportlist> supportList=homeMapper.supportlist();
        JSONArray jsonArray=new JSONArray();
        for (Supportlist s:supportList
             ) {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("img",s.getImg());
            jsonObject.put("title",s.getTitle());
            jsonObject.put("show",s.getShow());
            JSONArray  jsonArray1=new JSONArray();
            jsonArray1.add(s.getIintroductory());
            jsonObject.put("iintroductory",jsonArray1);
            jsonArray.add(jsonObject);
        }

        return jsonArray;

    }
    @RequestMapping("supportList1")
    public JSONArray supportList(){
        List<Supportlist> supportList=homeMapper.supportlist();
        JSONArray jsonArray=new JSONArray();
        for (Supportlist s:supportList
        ) {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("img",s.getImg());
            jsonObject.put("title",s.getTitle());
            jsonObject.put("show",s.getShow());
            JSONArray  jsonArray1=new JSONArray();
            jsonArray1.add(s.getIintroductory());
            jsonObject.put("iintroductory",jsonArray1);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
    @RequestMapping("maplist")
    public JSONArray maplist(){
        List<Mapdate> maplist=homeMapper.maplist();
        JSONArray jsonArray=new JSONArray();
        for (Mapdate m:maplist
        ) {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("mapName",m.getName());
            JSONArray jsonArray1=new JSONArray();
            jsonArray1.add(Double.parseDouble(m.getJd()));
            jsonArray1.add(Double.parseDouble(m.getWd()));
            jsonArray1.add(m.getContent());
            jsonObject.put("mapValue",jsonArray1);
            jsonObject.put("status",m.getStatus());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    @RequestMapping("bzhlist")
    public JSONArray bzhlist(){
        List<Bzhlist> Bzhlist=yjfxMapper.bzhlist();
        JSONArray jsonArray=new JSONArray();
        int i=1
                ;
        for (Bzhlist b:Bzhlist
        ) {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("ppdz",b.getPpdz());
            jsonObject.put("bzhdz",b.getBzhdz());
            jsonObject.put("status",b.getStatus());
            jsonObject.put("id",i);
            i++;
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
