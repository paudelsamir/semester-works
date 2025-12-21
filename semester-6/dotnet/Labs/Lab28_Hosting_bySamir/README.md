# Lab 28: Hosting ASP.NET Core Application

**Student:** Samir Paudel (114-079/D)

## Overview
Guide for deploying ASP.NET Core applications to cloud platforms with documentation and screenshots.

## Deployment Options

### Option 1: Azure App Service ⭐ (Recommended)
- Microsoft's official platform for .NET apps
- Free tier available
- Automatic SSL/HTTPS
- Built-in CI/CD with GitHub

**Steps:**
1. Create Azure account (free tier)
2. Prepare application: `dotnet publish -c Release`
3. Create App Service plan and web app
4. Deploy via Azure CLI or Visual Studio
5. Configure database connection string
6. Access at: `https://yourapp.azurewebsites.net`

### Option 2: Heroku (with Docker)
- Simple deployment
- Free dyno available (limited)
- Good for testing

**Steps:**
1. Create Dockerfile
2. Install Heroku CLI
3. Create app: `heroku create appname`
4. Push to Heroku: `git push heroku main`
5. Access at: `https://appname.herokuapp.com`

### Option 3: Railway.app
- GitHub integration
- Simple configuration
- Auto-deploys on git push

**Steps:**
1. Connect GitHub repository
2. Railway detects .NET project
3. Add database (PostgreSQL/MySQL)
4. Auto-deployment on push

### Option 4: Somee.com
- Free ASP.NET hosting
- MSSQL database included
- FTP upload support

**Steps:**
1. Register account
2. Create new website
3. Prepare files: `dotnet publish -c Release`
4. Upload via FTP
5. Configure database

## Pre-Deployment Checklist

- [ ] Set environment to Production
- [ ] Update connection strings for production database
- [ ] Disable detailed error pages
- [ ] Enable HTTPS redirection
- [ ] Test in Release mode locally
- [ ] Apply all database migrations

## Security Considerations

- Use environment variables for secrets
- Never commit connection strings to git
- Enable HTTPS
- Configure CORS properly
- Set secure cookie options
- Hide sensitive data in error pages

## Post-Deployment

- [ ] Verify all pages load correctly
- [ ] Test database operations
- [ ] Check application logs
- [ ] Monitor performance
- [ ] Set up custom domain (optional)

## Documentation Required for Screenshots

1. **Platform Dashboard** - Showing deployed app
2. **Configuration** - Environment variables (hide secrets)
3. **Deployment Logs** - Successful build/deploy
4. **Live URL** - Application running in browser
5. **Database Connection** - Connected database
6. **Application Features** - Working pages
7. **Logs/Monitoring** - Application insights

## Platform Comparison

| Platform | Pros | Cons | Best For |
|----------|------|------|----------|
| Azure | Professional, scalable | Learning curve | Production apps |
| Heroku | Easy setup | Sleep after 30min free | Testing/demos |
| Railway | GitHub integration | Bandwidth limits | Quick deploys |
| Somee | Free ASP.NET | Limited resources | Learning |

## Example: Azure Deployment Commands

```bash
# Login
az login

# Create resource group
az group create --name Lab28RG --location eastus

# Create App Service plan
az appservice plan create --name Lab28Plan --resource-group Lab28RG --sku F1 --is-linux

# Create web app
az webapp create --name lab28bysamir --resource-group Lab28RG --plan Lab28Plan --runtime "DOTNET|8.0"

# Publish
dotnet publish -c Release -o ./publish

# Deploy
az webapp deployment source config-zip --resource-group Lab28RG --name lab28bysamir --src-path ./publish.zip
```

## Common Issues

### Issue: Database Connection Fails
**Solution:** Ensure connection string has production database credentials and firewall allows connection

### Issue: Application Won't Start
**Solution:** Check logs, verify .NET runtime version, ensure migrations applied

### Issue: 500 Internal Error
**Solution:** Enable detailed errors temporarily to debug, check logs
