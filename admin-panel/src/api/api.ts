import httpClient from "@/api/httpClient";
import {Bet} from "@/models/bet/Bet";

const BASE = "http://localhost:8181";
const BASE_ = "http://localhost:8182";
const BET = "/api/v1/bet"

const retrieveBets = () => httpClient.get(BASE_ + BET);
const addBet = (bet: Bet) => httpClient.post(BASE + BET, bet);

export {
    retrieveBets,
    addBet,
}