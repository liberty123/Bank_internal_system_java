const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootc004o809/",
            name: "springbootc004o809",
            // Out到Homelink
            indexUrl: 'http://localhost:8080/springbootc004o809/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "The bank's internal management system"
        } 
    }
}
export default base
