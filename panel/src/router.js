import {createRouter, createWebHistory} from "vue-router";
import BetList from "@/components/bet/BetList.vue";
import AddBet from "@/components/bet/Bet.vue";

const routes = [
    {
        path: "/",
        name: 'Home',
        component: BetList,
    },
    {
        path: "/bets",
        name: 'BetList',
        component: BetList
    },
    {
        path: "/bets/place",
        name: 'Place A Bet',
        component: AddBet
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;