<template>
  <div class="card" v-bind:class="{read: book.read}">
      <h2 class="book-title">{{ book.title }}</h2>
      <h3 class="book-author">{{book.author}}</h3>
      <img class="book-image" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" alt="">
      <button class="mark-read" v-if="book.read == false" v-on:click="onReadChange()"> Mark Read </button>
      <button class="mark-unread" v-if="book.read" v-on:click="onReadChange()"> Mark Unread </button>
  </div>
</template>

<script>
export default {
    name: 'book-card',
    props: ['book'],
    methods : {
        onReadChange() {
            this.$store.commit('FLIP_READ_STATUS', this.book);
        }
    }
}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
    position: relative;
}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1.5rem;
}

.card .book-author {
    font-size: 1rem;
}

.book-image {
    width: 80%;
}

.mark-read, .mark-unread {
    display: block;
    position: absolute;
    bottom: 40px;
    width: 80%;
    left: 10%;
    font-size: 1rem;
}
</style>