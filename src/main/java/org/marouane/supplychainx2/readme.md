# Spring Security Documentation

## 🔐 Authentication vs Authorization

### **Authentication**
Process of verifying the identity of a user.

### **Authorization**
Process of checking permissions or roles to determine what authenticated users can access.

---

# ⚠️ Common Web Attacks & Spring Security Protection

## 🧨 Brute Force Attack
**Attack:**  
The attacker tries many passwords automatically until one works.

**Protection:**
- Limit login attempts
- Add CAPTCHA
- Use strong passwords
- Lock account after several failed logins

---

## 🧪 XSS (Cross-Site Scripting)
**Attack:**  
Attacker injects malicious JavaScript into the application.

**Protection:**
- HTML escaping
- Sanitizing inputs
- Using frameworks that escape by default (Thymeleaf, etc.)

---

## 🎯 CSRF (Cross-Site Request Forgery)
**Attack:**  
Attacker tricks an authenticated user into performing an unwanted action.

**Protection:**
- CSRF tokens (enabled by default in Spring Security)

---

## 🧵 Session Fixation
**Attack Example:**
1. Attacker creates a session (`ABC123`)
2. Sends it to the victim
3. Victim logs in with that session
4. Attacker reuses it to access account

**Protection:**
- Spring Security regenerates session ID after login

---

## 🕵️ Session Hijacking
**Methods:**
- Sniffing HTTP (no HTTPS)
- XSS to steal cookies
- Malware
- MITM attacks

**Protection:**
- Use HTTPS
- Secure cookies
- Short session timeout
- Session ID regeneration

---

# 🔒 Why HTTPS Is Important

### ✔ Data Encryption
Without HTTPS:  
Passwords, emails, tokens, cookies… are readable by attackers.

With HTTPS:  
Data is encrypted and unreadable.

### ✔ MITM Protection
Prevents attackers from reading or modifying traffic.

### ✔ Prevents Session Hijacking
HTTPS encrypts cookies so they cannot be stolen.

### ✔ Server Authenticity
SSL certificates ensure the server is legitimate.

### ✔ SEO Benefits
Google ranks HTTPS sites higher.

### ✔ Required for modern features
- Service Workers
- Push notifications
- Geolocation
- Camera/Microphone access

---

# 🛡 Defense In Depth (Principle)

Using multiple layers of security so if one fails, others still protect the system.

### Goal:
- Make attacks harder
- Make attacks slower
- Increase cost for attackers
- Increase detection

---

## 🔰 Security Layers

### **1. Network Security**
- Firewalls
- VPN
- HTTPS
- Reverse proxy (Nginx)
- Limit open ports

### **2. Application Security**
- Authentication
- Authorization
- Input validation
- Protection against XSS, CSRF, SQL Injection
- BCrypt password hashing

### **3. Data Security**
- Encrypt sensitive data
- Secure environment variables
- Encrypt backups
- Restrict DB permissions

### **4. User Security**
- Strong passwords
- MFA
- Anti-phishing
- Session timeout

---

# 🔐 How Basic Auth Works (Spring Security Flow)

### 1️⃣ Client sends credentials in the header

Example:  
Plain: `test@example.com:password123`  
Base64: `dGVzdEBleGFtcGxlLmNvbTpwYXNzd29yZDEyMw==`

Header sent:
Authorization: Basic dGVzdEBleGFtcGxlLmNvbTpwYXNzd29yZDEyMw==
---

### 2️⃣ Spring Security decodes Base64
Extracts:
- email
- password

---

### 3️⃣ Calls UserDetailsService

If not found → **401 Unauthorized**

---

### 4️⃣ Password verification
Uses BCrypt:
If matched → authentication succeeds.

---

### 5️⃣ SecurityContext is created
Spring stores authenticated user details.

---

### 6️⃣ Authorization rules applied
Examples:
.anyRequest().authenticated()

@PreAuthorize("hasRole('ADMIN')")


---

# ✅ End of Documentation

