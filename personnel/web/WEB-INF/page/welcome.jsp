<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>人事管理系统</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="${ctx}/public/lib/favicon.png" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/public/css/font.css">
    <link rel="stylesheet" href="${ctx}/public/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${ctx}/public/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${ctx}/public/js/xadmin.js"></script>
</head>
<body class="bg" style="background-color: rgba(23,44,60,0.85)" >
<h1 style="text-align: center;font-size: 45px;color: #ffffff">人事管理系统</h1>
<div class="layui-carousel" id="test10" style="position: absolute;top: 30%;left: 12%;margin-top: -20px;margin-left: -50px">
    <div carousel-item="">
        <div style="width: 1100px;height: 500px" ><img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1592819395900&di=b1b8a8eb1ef8383690245efbf1bca362&imgtype=0&src=http%3A%2F%2Fpic129.nipic.com%2Ffile%2F20170510%2F22060368_152630194031_2.jpg"></div>
        <div style="width: 1100px;height: 500px"  ><img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1592820422078&di=48f3cc1f4adf222f28254da759e18703&imgtype=0&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D787116875%2C644646582%26fm%3D214%26gp%3D0.jpg"></div>
        <div style="width: 1100px;height: 500px" ><img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1592819290059&di=cd03228c7f8ad28ccf22746919902fac&imgtype=0&src=http%3A%2F%2Fpic65.nipic.com%2Ffile%2F20150425%2F8576167_103346254000_2.jpg"></div>
        <div style="width: 1100px;height: 500px" ><img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1592819283112&di=073140bf4a77f7b8ae7f612d4b7cf2c4&imgtype=0&src=http%3A%2F%2Ffile03.16sucai.com%2F2017%2F1100%2F16sucai_P591F9E160.JPG"></div>

    </div>
</div>


<script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['carousel', 'form'], function(){
        var carousel = layui.carousel
            ,form = layui.form;

        //常规轮播
        carousel.render({
            elem: '#test1'
            ,arrow: 'always'
        });

        //改变下时间间隔、动画类型、高度
        carousel.render({
            elem: '#test10'
            ,interval: 1500
            ,anim: 'fade'
            ,width: '1000px'
            ,height:'450px'
        });

        //设定各种参数
        var ins3 = carousel.render({
            elem: '#test3'
        });


        //事件
        carousel.on('change(test4)', function(res){
            console.log(res)
        });

        var $ = layui.$, active = {
            set: function(othis){
                var THIS = 'layui-bg-normal'
                    ,key = othis.data('key')
                    ,options = {};

                othis.css('background-color', '#5FB878').siblings().removeAttr('style');
                options[key] = othis.data('value');
                ins3.reload(options);
            }
        };

        //监听开关
        form.on('switch(autoplay)', function(){
            ins3.reload({
                autoplay: this.checked
            });
        });

        $('.demoSet').on('keyup', function(){
            var value = this.value
                ,options = {};
            if(!/^\d+$/.test(value)) return;

            options[this.name] = value;
            ins3.reload(options);
        });

        //其它示例
        $('.demoTest .layui-btn').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });
    });
</script>

</body>
</html>