var app = new Vue({
    el: '#app',

    data: {

        tableData: [],
        select: []
        // select2: []
        ,
        loading: false,
        PageDates : {}
        

    },
    mounted() {

        this.getPageInfo();
        this.openLoading();
        


    },
    methods: {
        deleteRow(index, rows) {
            rows.splice(index, 1);
        },
        handleClick(row) {
            console.log(row);
        },
        openLoading() {
            this.loading=true;

            setTimeout(() => {
            this.loading = false;
            }, 2000);
        },
        compile() {
            console.log("compile by oppenid ");
        },
        adduser(){

            location.href="addaudio.html";
        },
        getPageInfo(){
            axios.get('record/recordList?oppenid=1')
            .then(function (response) {
              console.log(response);
               this.tableData = response.data
                this.PageDates = response.data.recordListDtoList

            })
            .catch(function (error) {
              console.log(error);
            })

            
        },
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`);
          },
          handleCurrentChange(val) {
            console.log(`当前页: ${val}`);
          }
    }

});