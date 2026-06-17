// src/app/layout.js

export const metadata = {
  title: 'Sistema Emergencias Valle del Sol ☀️',
  description: 'Panel de Control Municipal - Framework Next.js',
};

export default function RootLayout({ children }) {
  return (
    <html lang="es">
      <body style={{ 
        margin: 0, 
        padding: 0, 
        backgroundColor: '#F8FAFC',
        fontFamily: 'system-ui, -apple-system, sans-serif'
      }}>
        {children}
      </body>
    </html>
  );
}