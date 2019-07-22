var app=new Vue({
    el:'#app',
    data:{
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
    methods: {
        onSubmit() {
          console.log('submit!');
        }
      }
})