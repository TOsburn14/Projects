import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  list() {
    return http.get('/topics');
  },

  get(id) {
    return http.get(`/topics/${id}`);
  },

  postTopic(topic) {
    return http.post(`/topics/`,topic);
  },

  updateTopic(topicId, topic) {
    return http.put(`/topics/${topicId}`,topic);
  },

  deleteTopic(topicId) {
    return http.delete(`/topics/${topicId}`);
  }



}
