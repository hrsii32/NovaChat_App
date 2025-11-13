# 🚀 NovaChat – AI-Powered Chatbot  
### Spring Boot + Angular 20 + Gemini 2.5 Flash

NovaChat is a modern full-stack AI chatbot that combines a **Spring Boot backend**, **Angular 20 frontend**, and **Google Gemini 2.5 Flash** for smart conversational responses.

---

## 🌟 Meaning of “NovaChat”

The name **NovaChat** comes from two meaningful words:

- **Nova** → A bright, explosive burst of light from a star.  
  Symbolizes **innovation, brilliance, and next-generation intelligence**.

- **Chat** → Conversation or messaging.

### 👉 Combined Meaning  
**NovaChat = A bright, intelligent new way to chat — shining like a nova with fast and powerful AI responses.**

---

# 📌 Features

### ✔ AI-powered chat using Gemini 2.5 Flash  
### ✔ Spring Boot REST backend  
### ✔ Angular 20 standalone frontend  
### ✔ Clean UI with message bubbles & typing animation  
### ✔ Error handling for API overload (503), network issues  
### ✔ Modular and extensible code architecture  

---

# 🏗 Tech Stack

### **Backend**
- Java 17  
- Spring Boot 3.3+  
- RestTemplate  
- Maven  
- Gemini REST API

### **Frontend**
- Angular 20 (standalone components)  
- HttpClient  
- TypeScript  
- Custom CSS for modern UI

---

# 📂 Project Structure

```
chatbot_app/
│
├── backend/
│   ├── controller/
│   ├── service/
│   └── dto/
│
└── frontend/
    ├── app/
    │   ├── app.component.ts
    │   ├── chat/chat.component.ts
    │   ├── chat/chat.component.html
    │   ├── chat/chat.component.css
    │   └── services/chat.service.ts
    └── styles.css
```

---

# 🔧 Backend Setup

### 1️⃣ Add configuration in `application.properties`:

```properties
spring.application.name=novachat
server.port=8080

gemini.api.url=https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent
gemini.api.key=YOUR_API_KEY_HERE
gemini.api.model=gemini-2.5-flash
```

### 2️⃣ Run Backend

```bash
mvn spring-boot:run
```

API will run at:

```
http://localhost:8080/api/chat
```

---

# 🎨 Frontend Setup (Angular 20)

### 1️⃣ Install dependencies

```bash
npm install
```

### 2️⃣ Run Angular application

```bash
ng serve --open
```

Frontend URL:

```
http://localhost:4200
```

---

# 🧪 API Details

### **POST /api/chat**

#### Request

```json
{
  "message": "Tell me about yourself"
}
```

#### Response

```json
{
  "reply": "I am a Gemini-powered AI..."
}
```

---

# 🖼 UI Screenshot Section

(Add screenshots here once UI is visible)

```
📸 /screenshots/home.png
📸 /screenshots/chat.png
```

---

# 🚀 Future Enhancements

- Save chat history  
- Streamed AI responses  
- Voice input  
- User profiles  
- Dark/Light mode  

---

# 🤝 Contributing

Pull requests are welcome!  
For major changes, open an issue to discuss the proposal.

---

# 📜 License

MIT License.

---

