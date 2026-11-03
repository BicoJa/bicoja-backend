package com.bicoja.bicoja.config;

import java.time.LocalDateTime;

public record ApiError(LocalDateTime timestamp, int status, String erro) {}
