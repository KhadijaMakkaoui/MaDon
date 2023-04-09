# Use the official image as a parent image.
FROM ubuntu:20.04

# Set the working directory to /app
WORKDIR /app

# Install the required dependencies
RUN apt-get update && apt-get install -y curl git unzip libgconf-2-4 libstdc++6 libglu1-mesa fonts-droid-fallback lib32stdc++6 python3

# Install Flutter
RUN git clone https://github.com/flutter/flutter.git /usr/local/flutter
ENV PATH="/usr/local/flutter/bin:/usr/local/flutter/bin/cache/dart-sdk/bin:${PATH}"
RUN flutter precache && flutter doctor

# Copy the rest of the app's source code
COPY . .

# Build the app for web
RUN flutter build web

# Expose the default port for the Flutter web server
EXPOSE 5000

# Start the app
CMD ["flutter", "run", "-d", "web-server", "-v"]
