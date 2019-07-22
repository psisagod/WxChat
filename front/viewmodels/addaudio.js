var app = new Vue({
    el: '#app',
    name: 'productdetailspage',
    data: {

        form: {
            name: '',
            region: '',
            date1: '',
            date2: '',
            delivery: false,
            type: [],
            resource: '',
            desc: ''
          }

    },
    mounted() {
        
    },
    methods: {
        
        onCancel(){
            console.log("create audio");
        },
        onSubmit(){
            console.log("create audio");
        }

    }


});