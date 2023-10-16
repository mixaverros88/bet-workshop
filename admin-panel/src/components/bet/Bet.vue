<template>
  <div>

    <div>
      <Form @submit="onSubmit" :validation-schema="schema">

        <div class="grid md:grid-cols-2 md:gap-6">

          <div class="input-wrapper">
            <label for="password" class="input-label">Bet Amount</label>
            <Field name="amount" v-model="bet.amount" type="text" class="input-text"/>
            <ErrorMessage name="amount" class="input-warring"/>
          </div>

          <div class="input-wrapper">
            <label for="password" class="input-label">Home Team</label>
            <Field name="homeTeam" v-model="bet.homeTeam" type="text" class="input-text"/>
            <ErrorMessage name="homeTeam" class="input-warring"/>
          </div>

          <div class="input-wrapper">
            <label for="password" class="input-label">Away Team</label>
            <Field name="awayTeam" v-model="bet.awayTeam" type="text" class="input-text"/>
            <ErrorMessage name="awayTeam" class="input-warring"/>
          </div>

          <div class="input-wrapper">
            <label for="password" class="input-label">Selection</label>
            <Field name="selection" v-model="bet.selection" type="text" class="input-text"/>
            <ErrorMessage name="selection" class="input-warring"/>

          </div>


        </div>

        <div class="grid md:grid-cols-1 md:gap-6">
          <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 my-1 rounded">Submit</button>
        </div>
        
        <base-toast v-if="isSuccess" :description="msg" mode="SUCCESS"/>
        <base-toast v-if="hasError" :description="msg" mode="ERROR"/>

      </Form>
    </div>

  </div>
</template>

<script lang="ts" setup>
import {Form, Field, ErrorMessage} from 'vee-validate';
import * as yup from 'yup';
import {addBet} from "@/api/api";
import {ref} from "vue";
import BaseToast from "@/components/common/BaseToast.vue";
import {Bet} from "@/models/bet/Bet";

const isSuccess = ref(false);
const hasError = ref(false);
const bet = ref({} as Bet);
let msg = ref();

const schema = yup.object({
  amount: yup.string().required(),
  homeTeam: yup.string().required(),
  awayTeam: yup.string().required(),
  selection: yup.string().required(),
});

function onSubmit(values: any) {
  console.log('sss')
    addBet(values).then(resp => {
      isSuccess.value = true
      msg.value = "Bet has been created Successfully";
      setTimeout(() => isSuccess.value = false, 3000);
    }).catch(() => {
      hasError.value = true
      msg.value = "An error has been occurred";
      setTimeout(() => hasError.value = false, 3000);
    })
}

</script>