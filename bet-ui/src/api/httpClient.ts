import axios from "axios";

const httpClient = axios.create({
    baseURL: '',
    timeout: 5000
})

export default httpClient;