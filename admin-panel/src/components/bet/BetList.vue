<template>
  <div>

    <div v-if="hasBets" class="global">
      <div class="table-wrapper">
        <table class="main-table">
          <thead class="main-thead">
          <tr>
            <th scope="col" class="main-th">ID</th>
            <th scope="col" class="main-th">Amount</th>
            <th scope="col" class="main-th">Home Team</th>
            <th scope="col" class="main-th">Away Team</th>
            <th scope="col" class="main-th">Selection</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="bet in bets" v-bind:key="bet.amount" class="main-table-row-tr">
            <th scope="row" class="main-table-row-th">{{ bet.id }}</th>
            <th scope="row" class="main-table-row-th">{{ bet.amount }}</th>
            <th scope="row" class="main-table-row-th">{{ bet.homeTeam }}</th>
            <th scope="row" class="main-table-row-th">{{ bet.awayTeam }}</th>
            <th scope="row" class="main-table-row-th">{{ bet.selection }}</th>
          </tr>
          </tbody>
        </table>
      </div>
    </div>

    <base-alert v-if="!hasBets" mode="WARNING" title="No Results Has Been Found"/>
  </div>
</template>

<script lang="ts" setup>
import {ref} from "vue";
import { retrieveBets } from '@/api/api'
import {Bet} from "@/models/bet/Bet";
import BaseAlert from "@/components/common/BaseAlert.vue";

const bets = ref([] as Bet[]);
const showTotalRevenue = ref(false);
const hasBets = ref(true);


let getAllBets = () => {
  retrieveBets().then(b => {
    bets.value = b.data
    showTotalRevenue.value = true;
    if (bets.value.length === 0) {
      hasBets.value = false
    } else {
      hasBets.value = true
    }
  })
}

getAllBets();

</script>
