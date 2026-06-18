/** @type {import('next').NextConfig} */
const nextConfig = {
  async rewrites() {
    return [
      {
        // Cada vez que Next.js vea una llamada a /api/v1/..., la mandará a Kong de forma interna
        source: '/api/v1/:path*',
        destination: 'http://127.0.0.1:8000/api/v1/:path*',
      },
    ];
  },
};

module.exports = nextConfig;