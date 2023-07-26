<template>
  <div class="book-container">
    <BookCardVue v-for="book in $store.state.books" v-bind:key="book.isbn" 
    v-bind:book="book"/>
  </div>
</template>

<script>
import BookCardVue from './BookCard.vue'

export default {
    name: 'reading-list',
    components: {
      BookCardVue
    },


}
</script>

<style>
.book-container {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>