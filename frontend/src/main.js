import Vue from 'vue'
import App from './App.vue'
import router from './router/_router'
import VueSession from 'vue-session'
import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';
import ToastedPlugin from "vue-toasted";

Vue.config.productionTip = false
Vue.use(VueSession)
Vue.use(VueSweetalert2, options);
Vue.use(ToastedPlugin, options)

const options = {
  confirmButtonColor: '#41b882',
  cancelButtonColor: '#ff7674',
};

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')


