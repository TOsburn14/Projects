<template>
  <div>
      <ReadingListVue />
      <router-link v-bind:to="{ name: 'new-book-form' }">Add Book to Reading List</router-link>
      
  </div>
</template>

<script>
import ReadingListVue from '../components/ReadingList.vue'
export default {
    components: {
        ReadingListVue
    }
}
</script>

<style>

</style>