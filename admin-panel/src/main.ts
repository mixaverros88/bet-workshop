import {createApp} from 'vue'
import App from './App.vue'
import './assets/css/tailwind.css'
import '@/assets/css/table.scss'
import '@/assets/css/style.scss'
import router from './router';
import BaseAlert from "@/components/common/BaseAlert.vue";
import BaseToast from "@/components/common/BaseToast.vue";

const app = createApp(App);

app.use(router)
    .component('base-toast', BaseToast)
    .component('base-alert', BaseAlert)
    .mount('#app');