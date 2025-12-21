# Lab 25: State Management in ASP.NET Core

**Student:** Samir Paudel (114-079/D)

## Overview
Demonstrates 6 state management techniques in ASP.NET Core:
1. **Session State** - Server-side (survives across requests)
2. **HttpContext.Items** - Single request only
3. **TempData** - Survives one redirect
4. **Cookies** - Client-side storage
5. **Query Strings** - URL parameters
6. **Hidden Fields** - Form data

## Techniques Comparison

| Technique | Storage | Lifetime | Max Size |
|-----------|---------|----------|----------|
| Session | Server | Until timeout | Unlimited |
| HttpContext.Items | Server | Single request | Unlimited |
| TempData | Server/Cookie | One redirect | Session limit |
| Cookies | Client | Set expiration | 4KB each |
| Query String | Client | Single request | URL limit |
| Hidden Fields | Client | Form post | Unlimited |

## Demo Files
- `StateController.cs` - Controller demonstrating all techniques
- `StateView.cshtml` - Razor view showing all state techniques
