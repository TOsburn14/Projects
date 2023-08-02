import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  get(id) {
    return http.get(`/messages/${id}`);
  },

  saveMessage(message) {
    return http.post(`/messages/`,message);
  },

  updateMessage(messageId, message) {
    return http.put(`/messages/${messageId}`,message);
  },

  deleteMessage(messageId) {
    return http.delete(`/messages/${messageId}`);
  }


}
