<template>
  <div>

    <div>
      <Form @submit="onSubmit" :validation-schema="schema">

        <div class="grid md:grid-cols-3 md:gap-6">

          <div class="input-wrapper">
            <label for="password" class="input-label">Bet Amount</label>
            <Field name="amount" v-model="bet.amount" type="text" class="input-text"/>
            <ErrorMessage name="amount" class="input-warring"/>
            <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 my-1 rounded">Submit</button>
          </div>


        </div>

        <base-toast v-if="isSuccess" :description="msg" mode="SUCCESS"/>

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
const bet = ref({} as Bet);
let msg = ref();

const schema = yup.object({
  amount: yup.string().required(),
});

function onSubmit(values: any) {
    addBet(values).then(resp => {
      isSuccess.value = true
      msg.value = "Bet has been created Successfully";
      setTimeout(() => isSuccess.value = false, 3000);
    })
}

</script>