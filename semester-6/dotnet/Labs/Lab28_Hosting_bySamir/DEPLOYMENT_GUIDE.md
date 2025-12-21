# Lab 28: Hosting Deployment Guide

## Quick Start - Choose Your Platform

### 🚀 Recommended: Azure App Service

#### Prerequisites
- Microsoft account (free)
- Azure CLI (optional)

#### 5-Minute Setup

```bash
# 1. Prepare application
cd /path/to/your/app
dotnet publish -c Release -o ./publish

# 2. Login to Azure portal (azure.microsoft.com)
# 3. Create resource group and App Service
# 4. Deploy files (upload or use Visual Studio publish)

# 5. Configure connection string in Azure Portal
#    → App → Settings → Connection strings
```

#### Access Your App
```
https://yourappname.azurewebsites.net
```

---

### 🐳 Heroku with Docker

#### Prerequisites
- Heroku account (free)
- Docker installed

#### Dockerfile
```dockerfile
FROM mcr.microsoft.com/dotnet/aspnet:8.0
WORKDIR /app
COPY publish/ .
ENTRYPOINT ["dotnet", "YourApp.dll"]
```

#### Deploy
```bash
heroku login
heroku create yourappname
git push heroku main
```

---

### 📦 Railway.app

#### Setup (30 seconds)
1. Go to railway.app
2. Login with GitHub
3. Create new project → Select your repo
4. Configure environment variables
5. Done! Auto-deploys on git push

---

### 🌐 Somee.com (Free ASP.NET)

1. Register at somee.com
2. Create new website
3. Get FTP credentials
4. Upload published files
5. Configure connection string

---

## Screenshots to Document

For your report, capture:

✅ **Before Deployment**
- Visual Studio publish dialog
- Release build output

✅ **Platform Setup**
- Platform dashboard
- Resource creation
- Configuration settings

✅ **Deployment Process**
- Upload/push logs
- Build logs
- Deployment confirmation

✅ **After Deployment**
- Live URL in browser
- Working application
- Database connected
- Features functioning

✅ **Monitoring**
- Application logs
- Performance metrics
- Error tracking

---

## Environment Variables

Store sensitive data as environment variables, NOT in code:

```
ConnectionString=Server=prod-server;Database=Lab28DB;User Id=admin;Password=***
LogLevel=Information
ASPNETCORE_ENVIRONMENT=Production
```

**In Azure Portal:**
- App → Configuration → Application settings
- Add new setting with key-value pair

---

## Deployment Verification Checklist

After deployment, test:

- [ ] Home page loads
- [ ] All links work
- [ ] Database queries execute
- [ ] HTTPS enabled
- [ ] Error pages display properly
- [ ] Images/CSS load correctly
- [ ] Forms submit successfully
- [ ] No console errors (F12)

---

## Troubleshooting

**App doesn't start?**
→ Check logs: `az webapp log tail --resource-group RG --name appname`

**Database connection fails?**
→ Verify connection string in production environment

**404 errors?**
→ Check routing configuration, ensure correct startup path

**HTTPS certificate issues?**
→ Azure/Heroku handle this automatically

---

## Next Steps

✨ Once deployed:
1. Custom domain setup (optional)
2. Auto-scaling configuration
3. CDN for static files
4. Backup strategy
5. Monitoring & alerts

**Congratulations! Your application is now live! 🎉**
