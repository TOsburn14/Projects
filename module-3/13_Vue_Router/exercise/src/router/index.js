import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home';
import MyBooks from '@/views/MyBooks';
import NewBookForm from '@/views/NewBook'
Vue.use(VueRouter);

const routes = [
{
  path: '/',
  component: Home,
  name: 'home'
},
{
  path: '/myBooks',
  component: MyBooks,
  name: 'my-books'
},
{
  path: '/addBook',
  component: NewBookForm,
  name: 'new-book-form'
}

]

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
