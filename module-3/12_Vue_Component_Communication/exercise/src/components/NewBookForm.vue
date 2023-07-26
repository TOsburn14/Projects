<template>
  <div>
    <form v-on:submit.prevent="addNewBook()" class="new-book-form">
      <div>
        <label for="title">Book Title</label>
        <input class="title-input" type="text" id="title" v-model.trim="newBook.title" />
      </div>
      <div>
        <label for="author">Book Author</label>
        <input class="author-input" type="text" id="author" v-model.trim="newBook.author" />
      </div>
      <div>
          <label for="isbn">Book ISBN</label>
          <input class="isbn-input" type="text" id="isbn" v-model.trim="newBook.isbn" />
      </div>
      <input type="submit" value="Save" />
      <input type="button" value="Cancel" @click.prevent="resetForm" />
    </form>
  </div>
</template>

<script>
export default {
  name: "add-book",
  data() {
    return {
      newBook: {
        read: false,
      },
    };
  },
  computed: {},
  methods: {
    addNewBook() {
      this.$store.commit("ADD_BOOK", this.newBook);
      this.resetForm();
    },
    resetForm() {
      this.newBook = {
        read: false,
      };
    },
  },
};
</script>

<style>
</style>