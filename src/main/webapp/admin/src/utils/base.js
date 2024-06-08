const base = {
    get() {
        return {
            url : "http://localhost:8080/shequguanli/",
            name: "shequguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/shequguanli/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于web的社区管理系统"
        } 
    }
}
export default base
