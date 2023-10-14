<template>
  <main-header/>
  <div class="container mx-auto p-4 sm:ml-64 ">
    <router-view v-slot="slotProps">
      <transition name="route" mode="out-in">
        <component :is="slotProps.Component"/>
      </transition>
    </router-view>
  </div>

</template>

<script lang="ts">
import {Options, Vue} from 'vue-class-component';
import MainHeader from './components/common/LeftMenu.vue';

@Options({
  components: {
    MainHeader
  },
})
export default class App extends Vue {
}
</script>
