// store.js
const store = new Vuex.Store({
    state: {
        LOADING: false
    },
    mutations: {
        showLoading(state){
            state.LOADING = true    
        },
        hideLoading (state) {
            state.LOADING = false
        }
    }
})
