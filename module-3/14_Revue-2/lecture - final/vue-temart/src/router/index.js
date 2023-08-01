import Vue from 'vue'
import VueRouter from 'vue-router'
import ProductsView from '@/views/ProductsView.vue'
import SingleProductView from '@/views/SingleProductView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'products',
    component: ProductsView
  },
  {
    path: '/products/:productId',
    name: 'single-product-view',
    component: SingleProductView
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
