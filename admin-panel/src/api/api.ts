import httpClient from "@/api/httpClient";
import {Bet} from "@/models/bet/Bet";

const BASE = "http://localhost:8181";
const BET = "/api/v1/bet"

const retrieveBets = () => httpClient.get(BASE + BET);
const addBet = (bet: Bet) => httpClient.post(BASE + BET, bet);

export {
    retrieveBets,
    addBet,
}