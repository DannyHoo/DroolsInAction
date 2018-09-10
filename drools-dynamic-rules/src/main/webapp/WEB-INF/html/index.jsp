<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Drools规则计算</h2>

<form id="pointForm">
    用户名：<input type="text" id="userName" name="userName" placeholder="请输入用户名"><br/>
    当前积分：<input type="text" id="point" name="point" placeholder="请输入用户当前积分"><br/>
    当日购物次数：<input type="text" id="buyNums" name="buyNums" placeholder="请输入用户当日购物次数"><br/>
    当日购物金额：<input type="text" id="buyMoney" name="buyMoney" placeholder="请输入用户当日购物金额"><br/>
    当日退货次数：<input type="text" id="backNums" name="backNums" placeholder="请输入用户当日退货次数"><br/>
    当日退货金额：<input type="text" id="backMoney" name="backMoney" placeholder="请输入用户当日退货金额"><br/>
    <input type="button" value="根据以上数据计算用户积分" onclick="calcPoints();"><br/>
    <label id="finalPoints"></label>
</form>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

    function calcPoints() {
        $.post(
                "/calc.action",
                $("#pointForm").serialize(),
                function (data) {
                    $("#finalPoints").text("用户" + $("#userName").val() + "的最终积分为" + data.data.point + "");
                });
    }
</script>
</body>
</html>
