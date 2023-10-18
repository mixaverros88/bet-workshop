<template>
  <div>

    <div>
      <Form @submit="onSubmit" :validation-schema="schema">

        <div class="grid md:grid-cols-2 md:gap-6">

          <div class="input-wrapper">
            <label for="homeTeam" class="input-label">Home Team</label>
            <Field name="homeTeam" v-model="bet.homeTeam" as="select" class="input-select">
              <option value="" disabled>Select Home Team</option>
              <option v-for="team in teams" :key="team" :value="team">
                {{ team }}
              </option>
            </Field>
            <ErrorMessage name="homeTeam" class="input-warring"/>
          </div>

          <div class="input-wrapper">
            <label for="awayTeam" class="input-label">Away Team</label>
            <Field name="awayTeam" v-model="bet.awayTeam" as="select" class="input-select">
              <option value="" disabled>Select Away Team</option>
              <option v-for="team in teams" :key="team" :value="team">
                {{ team }}
              </option>
            </Field>
            <ErrorMessage name="awayTeam" class="input-warring"/>
          </div>

          <div class="input-wrapper">
            <label for="selection" class="input-label">Selection</label>
            <Field name="selection" v-model="bet.selection" as="select" class="input-select">
              <option value="" disabled>Select Selection</option>
              <option v-for="selection in selections" :key="selection" :value="selection">
                {{ selection }}
              </option>
            </Field>
            <ErrorMessage name="selection" class="input-warring"/>
          </div>

          <div class="input-wrapper">
            <label for="amount" class="input-label">Bet Amount</label>
            <Field name="amount" v-model="bet.amount" type="text" class="input-text"/>
            <ErrorMessage name="amount" class="input-warring"/>
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
const teams = ref(['LIVERPOOL', 'AJAX', 'ALKMAAR', 'BARCELONA', 'MILAN', 'INTER', 'LYON', 'BRAGA']);
const selections = ref(['1', 'X', '2']);
const bet = ref({} as Bet);
let msg = ref();

const schema = yup.object({
  amount: yup.string().matches(/^[0-9]+$/, "Must be only digits")
      .min(1, 'Must be minimum 1 digits')
      .max(5, 'Must be maximum 5 digits').required(),
  homeTeam: yup.string().required().notOneOf([yup.ref('awayTeam'), null], 'Home Team and Away Team should not be equal'),
  awayTeam: yup.string().required().notOneOf([yup.ref('homeTeam'), null], 'Home Team and Away Team should not be equal'),
  selection: yup.string().required(),
});

function onSubmit(values: any) {
  addBet(values).then(() => {
    isSuccess.value = true
    msg.value = "Bet has been accepted";
    setTimeout(() => isSuccess.value = false, 3000);
  }).catch((error: any) => {
    hasError.value = true
    msg.value = "An error has been occurred";
    if (error.response?.data?.detail) {
      msg.value = error.response.data.detail
    }
    setTimeout(() => hasError.value = false, 3000);
  })
}

</script>