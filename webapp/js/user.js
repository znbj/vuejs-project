new Vue({
    el:"#app",
    data:{
        userList:[],
        user:{}
    },
    methods:{
        init:function () {
            var _this = this;
            //使用axios发送ajax请求，请求用户列表
            axios.get("/user/list.do")
                .then(function (response) {
                    //取服务端响应的数据
                    _this.userList = response.data;
                })
                .catch(function (reason) {
                    console.log(reason);
                })
        },
        showUserInfo:function (id) {
            var _this = this;
            //根据id查询用户数据
            axios.get("/user/"+id+".do")
                .then(function (response) {
                    _this.user = response.data;
                    //打开创建
                    $('#myModal').modal("show");
                })
        },
        doUpdate:function () {
            var _this = this;
            //把user发送到服务端即可
            axios.post("/user/update.do", this.user)
                .then(function (response) {
                    //刷新页面
                    _this.init();
                })
                .catch(function (reason) {
                    console.log(reason)
                })
        }
    },
    created: function() {
        this.init();
    }
});